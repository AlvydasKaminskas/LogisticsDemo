package eu.codeacademy.LogisticsDemo.services;


import eu.codeacademy.LogisticsDemo.converters.DispatchConverter;
import eu.codeacademy.LogisticsDemo.dto.DispatchDTO;
import eu.codeacademy.LogisticsDemo.entities.Dispatch;
import eu.codeacademy.LogisticsDemo.repositories.DispatchRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class DispatchService {
    private DispatchRepository dispatchRepository;
    private final String exceptionTxt = "Dispatch not found with id: ";

    public List<DispatchDTO> getAllDispatchesDTO() {

        return DispatchConverter.toDTOList(dispatchRepository.findAll());
    }

    public DispatchDTO getDispatchDTOById(Long id) {
        if (dispatchRepository.findById(id) != null) {
            return DispatchConverter.toDTO(dispatchRepository.findById(id).get());
        } else {
            throw new NoSuchElementException(exceptionTxt + id);
        }
    }

    public DispatchDTO createDispatch(DispatchDTO dispatchDTO) {
        Dispatch dispatch = DispatchConverter.toEntity(dispatchDTO);
        dispatchRepository.save(dispatch);
        return dispatchDTO;
    }

    public DispatchDTO updateDispatch(DispatchDTO dispatchDTO) throws NoSuchElementException {
        Dispatch dispatchToUpdate = dispatchRepository.findById(dispatchDTO.getId()).get();
        if (dispatchDTO.getName() != null) {
            dispatchToUpdate.setName(dispatchDTO.getName());
        }
        if (dispatchDTO.getEmail() != null) {
            dispatchToUpdate.setEmail(dispatchDTO.getEmail());
        }
        if (dispatchDTO.getPhoneNumber() != null) {
            dispatchToUpdate.setPhoneNumber(dispatchDTO.getPhoneNumber());
        }
        dispatchRepository.save(dispatchToUpdate);
        return DispatchConverter.toDTO(dispatchToUpdate);
    }

    public void deleteDispatch(Long id) {
        if (!dispatchRepository.existsById(id)) {
            throw new NoSuchElementException(exceptionTxt + id);
        }
        dispatchRepository.deleteById(id);
    }


}
