package afronski.playground.akka

import akka.actor.Props
import akka.actor.Actor
import akka.actor.ActorSystem

import akka.actor.OneForOneStrategy
import akka.actor.SupervisorStrategy._

import scala.concurrent.duration._

import afronski.playground.akka.actors._

class MainActor() extends Actor {
	override def preStart = {
		validOneTimeWorkerTest
		invalidOneTimeWorkerTest
	}

	override def postRestart(reason: Throwable) = {
		System.out.println(s"MainActor restarted because of: '$reason'.");
	}

	override val supervisorStrategy =
		OneForOneStrategy(maxNrOfRetries = 10, withinTimeRange = 1 minute) {
			case _ : Exception => {
				Restart
			}
		}

	//
	// Private methods
	//

	private def validOneTimeWorkerTest = {
		// One time worker test.
		val worker = OneTimeWorker.spawn(context.system, 1)

		worker ! DoWork(2)
		worker ! DoWork(4)
	}

	private def invalidOneTimeWorkerTest  {
		val worker = OneTimeWorker.spawn(context.system, 2)

		// Supervisor should restart worker.
		worker ! 0
		worker ! DoWork(3)
	}

	//
	// Received messages.
	//

	def receive = {
		case x: Int => {
			System.out.println(s"Received '$x' from '$sender'.")
		}
	}
}

object ActorPatterns extends App {
	start()

	def start() = {
		val system = ActorSystem("ActorPatterns")
		system.actorOf(Props[MainActor], name = "MainActor")
	}
}