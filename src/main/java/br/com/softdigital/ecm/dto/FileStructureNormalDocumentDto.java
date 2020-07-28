package br.com.softdigital.ecm.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FileStructureNormalDocumentDto {
	private String id;
	private boolean mandatoryVersionReview;
	private boolean documentExpires;
	private boolean notify;
	private boolean allowsDownload;
	private String mainFile;
	private Date validateFrom;
	private Date validUntil;
	private Integer expirationNotificationPeriod;
	private String description;
	private String comments;
	private String keyWords;
	private String versionDescription;
	private String parentId;
	private String fileExtension;
	private String fileName;
}
