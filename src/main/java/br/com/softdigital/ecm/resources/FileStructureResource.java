package br.com.softdigital.ecm.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.softdigital.ecm.domains.FileStructureDecorator;
import br.com.softdigital.ecm.dto.FileStructureSimpleDto;
import br.com.softdigital.ecm.services.FileStructureFolderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin
@RestController
@RequestMapping("/v1/file/structure")
@Api(description = "Navegação/Exibição")
public class FileStructureResource {
	
	@Autowired
	FileStructureFolderService service;
	
	@GetMapping
	@ApiOperation(value = "Retorna os arquivos que estão na pasta \"raiz\"")
	public ResponseEntity<List<FileStructureSimpleDto>> raiz() {
		List<FileStructureSimpleDto> list = service.findByParentId(null);
		return ResponseEntity.ok(list);
	}
	
	@GetMapping(path = "/all")
	@ApiOperation(value = "Retorna todos os arquivos sem respeitar o controle de pasta/sub-pasta (Apenas para teste)")
	public ResponseEntity<List<FileStructureDecorator>> list() {
		List<FileStructureDecorator> list = service.findAll();
		
		return ResponseEntity.ok(list);
	}
	
	@GetMapping(path = "/navigator/{parentId}")
	@ApiOperation(value = "Gerencia a navegação entre as pastas")
	public ResponseEntity<List<FileStructureSimpleDto>> listByParentId(@PathVariable String parentId) {
		List<FileStructureSimpleDto> list = service.findByParentId(parentId);
		return ResponseEntity.ok(list);
	}
	
	@GetMapping(path = "/content/{id}")
	@ApiOperation(value = "Exibi os dados do documento informado")
	public ResponseEntity<FileStructureDecorator> createFolder(@PathVariable String id) {
		FileStructureDecorator document = service.findById(id);
		return ResponseEntity.ok(document);
	}
	
}
