package isa.isa.bloodTransfusionCenter.mapper;

import isa.isa.bloodTransfusionCenter.domain.Center;
import isa.isa.bloodTransfusionCenter.dto.CenterDTO;
import isa.isa.user.dto.AddressDTO;
import isa.isa.user.mapper.AddressMapper;

import java.util.ArrayList;
import java.util.List;

public class CenterMapper {

    public static List<CenterDTO> mapCenterToCenterDTO(List<Center> centers){
        List<CenterDTO> centerDTOs = new ArrayList<CenterDTO>();
        for (Center c: centers) {
            AddressDTO a = AddressMapper.addressToAddressDTO(c.getAddress());
            CenterDTO cd = new CenterDTO(c.getDescription(),c.getName(), a.getAddress());
            centerDTOs.add(cd);
        }
        return centerDTOs;
    }
}
