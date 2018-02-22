package com.cubic.jpa.entity;

import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.PrePersist;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;

public class EncryptionListener {

	final private static String seed = "ssn";

	@PrePersist
	public void beforeInsert(final CustomerEntity entity) {
		String ssn = entity.getSsn();
		entity.setSsn(encrypt(ssn));

		/*
		 * System.out.println("@PrePersist=" + entity); String ssn = entity.getSsn();
		 * entity.setSsn(ssn); System.out.println("@PrePersist=" + entity);
		 */
	}

	@PostLoad
	public void afterLoad(final CustomerEntity entity) {
		String ssn = entity.getSsn();
		entity.setSsn(encrypt(ssn));
		// System.out.println("@PrePersist=" + entity);
	}

	@PostPersist
	public void afterInsert(final CustomerEntity entity) {
		String ssn = entity.getSsn();
		entity.setSsn(decrypt(ssn));
	}

	/*
	 * @PostPersist public void afterInsert(final CustomerEntity entity) {
	 * System.out.println("@PostPersist=" + entity); }
	 */
	private String encrypt(final String ssn) {
		final StandardPBEStringEncryptor decryptor = new StandardPBEStringEncryptor();
		decryptor.setPassword(seed);
		return decryptor.encrypt(ssn);
	}

	private String decrypt(final String ssnString) {
		final StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
		encryptor.setPassword(seed);
		return encryptor.decrypt(ssnString);
	}
}
