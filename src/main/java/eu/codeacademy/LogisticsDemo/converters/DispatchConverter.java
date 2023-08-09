package eu.codeacademy.LogisticsDemo.converters;

import eu.codeacademy.LogisticsDemo.dto.DispatchDTO;
import eu.codeacademy.LogisticsDemo.entities.Dispatch;

import java.util.ArrayList;
import java.util.List;

public abstract class DispatchConverter {

    public static DispatchDTO toDTO(Dispatch dispatch) {
        DispatchDTO dispatchDTO = new DispatchDTO();
        if (dispatch != null) {
            dispatchDTO.setId(dispatch.getId());
            dispatchDTO.setName(dispatch.getName());
            dispatchDTO.setEmail(dispatch.getEmail());
            dispatchDTO.setPhoneNumber(dispatch.getPhoneNumber());
        }
        return dispatchDTO;
    }
    public static Dispatch toEntity(DispatchDTO dispatchDTO) {
        Dispatch dispatch = new Dispatch();
        if (dispatchDTO != null) {
            dispatch.setId(dispatchDTO.getId());
            dispatch.setName(dispatchDTO.getName());
            dispatch.setEmail(dispatchDTO.getEmail());
            dispatch.setPhoneNumber(dispatchDTO.getPhoneNumber());
        }
        return dispatch;
    }
    public static List<DispatchDTO> toDTOList(List<Dispatch> dispatchs){
        List<DispatchDTO> dispatchDTOList = null;
        if (dispatchs != null && !dispatchs.isEmpty()){
            dispatchDTOList = new ArrayList<>();
            for (Dispatch d : dispatchs){
                dispatchDTOList.add(toDTO(d));
            }
        }
        return dispatchDTOList;
    }

}
