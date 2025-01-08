package com.ecom_project_backend.service;

import com.ecom_project_backend.entity.DeliveryAddress;
import com.ecom_project_backend.repository.DeliveryAddressRepository;
import com.ecom_project_backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeliveryAddressService {

    @Autowired
    private DeliveryAddressRepository deliveryAddressRepository;

    @Autowired
    private UserRepository userRepository;


    public DeliveryAddress getDeliveryAddressById(int id) {
        return deliveryAddressRepository.findById(id).get();
    }

    public List<DeliveryAddress> getALlDeliveryAddress() {
        return deliveryAddressRepository.findAll();
    }


    public DeliveryAddress updateAddress(DeliveryAddress deliveryAddress, int id) {

        DeliveryAddress deliveryAddress1 = deliveryAddressRepository.findById(id).get();
        if (deliveryAddress1 != null) {
            deliveryAddress1.setFirstName(deliveryAddress.getFirstName());
            deliveryAddress1.setLastName(deliveryAddress.getLastName());
            deliveryAddress1.setEmail(deliveryAddress.getEmail());
            deliveryAddress1.setMobileNo(deliveryAddress.getMobileNo());
            deliveryAddress1.setPincode(deliveryAddress.getPincode());
            deliveryAddress1.setVillageAndstreet(deliveryAddress.getVillageAndstreet());
            deliveryAddress1.setCity(deliveryAddress.getCity());
            deliveryAddress1.setState(deliveryAddress.getState());

            return deliveryAddressRepository.save(deliveryAddress1);
        }
            throw new NullPointerException(" Address is Null");
        }

        public DeliveryAddress deliveryAddressCreate (DeliveryAddress deliveryAddress)
        {
            return deliveryAddressRepository.save(deliveryAddress);
        }

        public void deleteDeliveryAddressById ( int id)
        {
            deliveryAddressRepository.deleteById(id);
        }


    }

