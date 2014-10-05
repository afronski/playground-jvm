package afronski.playground.akka.actors

import akka.actor.Props
import akka.actor.Actor
import akka.actor.ActorSystem

case class DoWork(factor: Int)

class RestartException(val message: String) extends Exception(message)

class OneTimeWorker extends Actor {
	override def postRestart(reason: Throwable) = {
		System.out.println(s"OneTimeWorker restarted because of: '$reason'.");
	}

	def receive = {
		case DoWork(x) => {
			sender ! x * 2

			// Diffrence between PoisonPill and context.stop(self):
			//
			//   PoisonPill will come after rest of messages gathered in the mailbox.
			//   So if your one time actor receive more then one request for 'do work' like below:
			//     worker ! DoWork(2)
			//     worker ! DoWork(3)
			//
			//   It will be processed before the PoisonPill, because pill will
			//   be send after the processing first request.

			System.out.println(s"OneTimeWorker '$self' received '$x' from '$sender' - quiting...")
			context.stop(self)
		}

		case _ => {
			throw new RestartException("Restarting OneTimeWorker because of unsupported message!")
		}
	}
}

object OneTimeWorker {
	def spawn(system: ActorSystem, uniqueness: Int) = {
		system.actorOf(Props[OneTimeWorker], name = s"hashed-id-$uniqueness")
	}
}