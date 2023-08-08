package eu.codeacademy.LogisticsDemo.converters;

import eu.codeacademy.LogisticsDemo.dto.DispatchDTO;
import eu.codeacademy.LogisticsDemo.entities.Dispatch;

public abstract class DispatchConverter {

    public static DispatchDTO toDTO(Dispatch dispatch) {
        DispatchDTO dispatchDTO = null;
        if (dispatch != null) {
            dispatchDTO.setId(dispatch.getId());
            dispatchDTO.setName(dispatch.getName());
            dispatchDTO.setEmail(dispatch.getEmail());
            dispatchDTO.setPhoneNumber(dispatch.getPhoneNumber());
        }
        return dispatchDTO;
    }
    public static Dispatch toEntity(DispatchDTO dispatchDTO) {
        Dispatch dispatch = null;
        if (dispatchDTO != null) {
            dispatch.setId(dispatchDTO.getId());
            dispatch.setName(dispatchDTO.getName());
            dispatch.setEmail(dispatchDTO.getEmail());
            dispatch.setPhoneNumber(dispatchDTO.getPhoneNumber());
        }
        return dispatch;
    }
}
