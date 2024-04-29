package dz.minagri.stat.location.service;

import dz.minagri.stat.location.entity.Address;
import dz.minagri.stat.location.repository.AddressRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Optional;

@Service
@AllArgsConstructor
@Transactional
@Slf4j
public class AddressService {

    private final AddressRepository addressRepository;

    public Collection<Address> List(int limit) {
        log.info("fetching all addressServices:{}" );
        return addressRepository.findAll(PageRequest.of(0,limit)).getContent();

    }
    public Address save(Address address){
        log.info("Save Address inside addressServices:{}");
        return addressRepository.save(address);

    }


    public Optional<Address> findAddressById(Long addressId) {
        log.info("findById inside  addressServices:{}" + addressId);
        return addressRepository.findById(addressId);
    }
}
