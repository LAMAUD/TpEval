package fr.treeptik.mdb;

import java.io.IOException;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
//L'interface MessageProducer est la super-interface des interfaces qui définissent des méthodes pour l'envoi de messages.
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.Session;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.treeptik.pojo.Stagiaire;

@WebServlet
public class StagiaireJMSServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(Stagiaire stagiaire) throws ServletException, IOException {
		String destinationName = "queue/stagiaireQueue";
		Context ic = null;
		ConnectionFactory connectionFactory = null;
		Connection connection = null;

		try {
			ic = new InitialContext();

			// J'ouvre la connection
			connectionFactory = (ConnectionFactory) ic
					.lookup("/ConnectionFactory");
			Queue queue = (Queue) ic.lookup(destinationName);

			connection = connectionFactory.createConnection();

			// Elle représente un contexte transactionnel de réception et
			// d'émission pour une connexion donnée.
			// C'est à partir d'un objet session que l'on crée des messages et
			// des objets à envoyer et à recevoir.
			// AUTO_ACKNOWLEDGE : l'accusé de réception est automatique, le MOM
			// reçoit l'accusé de réception à la réception du message que ce
			// dernier soit traité ou non par l'application
			// Pour obtenir une session, il faut utiliser la méthode
			// createSession() de l'interface Connection.
			Session session = connection.createSession(false,
					Session.AUTO_ACKNOWLEDGE);

			// une instance est obtenue en utilisant la méthode createProducer()
			// de l'interface Session avec en paramètre la destination
			MessageProducer publisher = session.createProducer(queue);

			connection.start();

			// ObjectMessage : message contenant un objet sérialisé
			// C'est un objet de type Session qui contient les méthodes
			// nécessaires à la création d'un message selon son type.
			ObjectMessage message = session.createObjectMessage(stagiaire);
			// send() permet l'envoie d'un message dans la file d'attente
			publisher.send(message);

		} catch (Exception exc) {
			exc.printStackTrace();
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (JMSException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
