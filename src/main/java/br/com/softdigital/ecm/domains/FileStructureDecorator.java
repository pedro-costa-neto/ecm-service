package br.com.softdigital.ecm.domains;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import br.com.softdigital.ecm.domains.enums.ControlIncrement;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

@Data
@Document("file_structure")
public abstract class FileStructureDecorator {
	
	@Id
	protected String id;
	
	protected boolean mandatoryVersionReview;
	protected boolean documentExpires;
	protected boolean notify;
	protected boolean allowsDownload;
	protected boolean trash;
	protected byte[] mainFile;
	protected Date validateFrom;
	protected Date validUntil;
	protected Integer versionReview;
	protected Integer expirationNotificationPeriod;
	protected BigDecimal fileSize;
	protected String description;
	protected String comments;
	protected String keyWords;
	protected String versionDescription;
	protected String parentId;
	protected String fileExtension;
	protected String fileName;
	protected String mainContent;
	
	@Setter(AccessLevel.NONE)
	protected Integer documentType;
	
	@Transient
	protected ControlIncrement controlIncrement;
	
	public abstract Integer getDocumentType();
}
