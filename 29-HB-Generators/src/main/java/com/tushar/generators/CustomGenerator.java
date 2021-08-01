package com.tushar.generators;

import java.io.Serializable;
import java.util.Random;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class CustomGenerator implements IdentifierGenerator {
	
	public CustomGenerator() {
		System.out.println("CustomGenerator.CustomGenerator()");
	}

	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
		System.out.println("CustomGenerator:::generate()");
		return "TK_"+new Random().nextInt(10000);
	}

}
