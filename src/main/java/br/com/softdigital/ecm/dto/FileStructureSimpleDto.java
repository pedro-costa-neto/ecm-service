package br.com.softdigital.ecm.dto;

import java.math.BigDecimal;

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
	private String parentId;
	private Integer documentType;
}
