package isa.isa.user.mapper;

import isa.isa.user.domain.User;
import isa.isa.user.dto.UserInformation;

public class UserMapper {

    public static UserInformation mapUserToUserInformation(User user){
        UserInformation ui = new UserInformation();
        ui.setCompany(user.getCompany());
        ui.setEmail(user.getEmail());
        ui.setJmbg(user.getJmbg());
        ui.setGender(user.getGender().toString());
        ui.setName(user.getName());
        ui.setProffesion(user.getProfession());
        ui.setSurnname(user.getSurname());
        ui.setUsername(user.getUsername());
        ui.setPhoneNumber(user.getPhoneNumber());
        ui.setAddress_id(AddressMapper.addressToAddressDTO(user.getAddress()).getAddress());

        return ui;
    }
}
