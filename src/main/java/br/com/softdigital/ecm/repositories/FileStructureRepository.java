package br.com.softdigital.ecm.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.softdigital.ecm.domains.FileStructureDecorator;
import br.com.softdigital.ecm.dto.FileStructureSimpleDto;

public interface FileStructureRepository extends MongoRepository<FileStructureDecorator, String>{

	List<FileStructureSimpleDto> findByParentId(String parentId);
}
