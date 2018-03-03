package com.eprescriptions.store;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StoreService {
	
	@Autowired
	private StoreRepository storeRepository;

}
