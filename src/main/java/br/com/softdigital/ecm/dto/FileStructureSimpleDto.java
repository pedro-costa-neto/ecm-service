package br.com.softdigital.ecm.dto;

import java.math.BigDecimal;

import br.com.softdigital.ecm.domains.FileStructureDecorator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FileStructureSimpleDto {
	private String id;
	private boolean notify;
	private boolean allowsDownload;
	private BigDecimal fileSize;
	private String description;
	private FileStructureDecorator parentId;
	private Integer documentType;
	
	public String getParentId() {
		return parentId != null ? parentId.getId() : null;
	}
}
