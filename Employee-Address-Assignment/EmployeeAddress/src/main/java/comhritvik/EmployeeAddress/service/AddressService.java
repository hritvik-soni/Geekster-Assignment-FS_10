package comhritvik.EmployeeAddress.service;

import comhritvik.EmployeeAddress.model.Address;
import comhritvik.EmployeeAddress.model.Employee;
import comhritvik.EmployeeAddress.repository.IAddressRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AddressService {
    @Autowired
    IAddressRepo addressRepo;

    public Iterable<Address> getAllAddress() {
        return addressRepo.findAll();
    }

    public Address getAddressbyid(Long addId) {

        Optional<Address> optional= addressRepo.findById(addId);

        if(optional.isPresent()){
            return optional.get();
        }
        return null;
    }

    public String addAddress(Address address) {
        addressRepo.save(address);
        return "Address Added";
    }

    public String UpdateAddress(Long addId, String addStreet) {
        if(addressRepo.existsById(addId)){
            Address address = getAddressbyid(addId);
            address.setAddStreet(addStreet);
            addressRepo.save(address);
            return "Address Updated";
        }
        else{
            return "Address Id does not exist";
        }
    }

    public String DeleteAddress(Long addId) {
        if(addressRepo.existsById(addId)){
            addressRepo.deleteById(addId);
            return "Address deleted";
        }
        else{
            return "Address Id does not exist";
        }
    }
}
