package LibraryService.service;

import LibraryService.entity.Library;
import LibraryService.repository.LibraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibraryService {
    @Autowired
    private LibraryRepository repository;

    public List<Library> getAllLibrary(){
        return repository.findAll();
    }
    public Library getLibraryById(int id) {
        return repository.findById(id).get();
    }

    public Library saveLibrary(Library library) {
        return repository.save(library);
    }

    public Library updateLibrary(Library library)
    {
        Library library1=repository.findById(library.getId()).orElse(null);
        library1.setName(library.getName());
        library1.setAddress(library.getAddress());
        library1.setEmail(library.getAddress());
        return repository.save(library1);
    }

}
