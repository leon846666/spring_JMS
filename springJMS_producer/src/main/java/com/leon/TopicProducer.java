package com.leon;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

@Component
public class TopicProducer {

	@Autowired
	private JmsTemplate jmsTemplate;

	@Autowired
	private Destination topicTextDestination;
	
	/**
	 * send text message 
	 * 
	 */
	public void sendTextMsg(final String text) {
		
		jmsTemplate.send(topicTextDestination,new MessageCreator() {
			
			public Message createMessage(Session session) throws JMSException {
				// TODO Auto-generated method stub
				return session.createTextMessage(text);
			}
		});
	}
}
