package com.vijay;

import java.util.Random;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class OrderIdGenerator  implements  IdentifierGenerator{

	@Override
	public Object generate(SharedSessionContractImplementor session, Object object) throws HibernateException {

		String code="Order";
		Integer id=new Random().nextInt(2000);
		return code+id;
		
	}

}
