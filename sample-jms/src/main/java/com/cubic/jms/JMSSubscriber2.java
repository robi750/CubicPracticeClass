package com.cubic.jms;

import java.util.Properties;

import javax.jms.Message;
import javax.jms.TextMessage;
import javax.jms.Topic;
import javax.jms.TopicConnection;
import javax.jms.TopicConnectionFactory;
import javax.jms.TopicSession;
import javax.jms.TopicSubscriber;
import javax.naming.Context;
import javax.naming.InitialContext;

import com.sun.messaging.jmq.jmsserver.core.Session;

public class JMSSubscriber2 {

	public static void main(String[] args) throws Exception {
		
		final Properties props = new Properties();
		props.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.enterprise.naming.SerialInitContextFactory");
		props.setProperty("org.omg.CORBA.ORBInitialHost", "localhost");
		props.setProperty("org.omg.CORBA.ORBInitialPort", "3700");
		final InitialContext ctx = new InitialContext(props);
		
		TopicConnectionFactory factory = (TopicConnectionFactory) ctx.lookup("jms/tcf");
		TopicConnection qc = null;
		
		try {
			qc = factory.createTopicConnection();
			qc.start();
			System.out.println("Got the Connection successfully");
			TopicSession session = qc.createTopicSession(false, Session.AUTO_ACKNOWLEDGE);
			Topic topic = (Topic) ctx.lookup("jms/MyTopic");
			TopicSubscriber ts = session.createSubscriber(topic);
			
			while(true) {
				Message msg = ts.receive(10000);
				System.out.println("SUBS2: ");
				System.out.println((msg !=null) ? ((TextMessage)msg).getText() : "NO MESSAGE");
				System.out.println();
			}
			//qc.stop();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
			if(qc !=null) {
				qc.close();
			}
		}
	}

}
