package eus.uni.dam;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the res_partner database table.
 * 
 */
@Entity
@Table(name="res_partner")
@NamedQuery(name="ResPartner.findAll", query="SELECT r FROM ResPartner r")
public class ResPartner implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private Boolean active;

	@Column(name="additional_info")
	private String additionalInfo;

	private String city;

	private Integer color;

	private String comment;

	@Column(name="commercial_company_name")
	private String commercialCompanyName;

	@Column(name="company_id")
	private Integer companyId;

	@Column(name="company_name")
	private String companyName;

	@Column(name="country_id")
	private Integer countryId;

	@Column(name="create_date")
	private Timestamp createDate;

	@Column(name="create_uid")
	private Integer createUid;

	/*@Column(name="credit_limit")
	private double creditLimit;
*/
	@Column(name="customer_rank")
	private Integer customerRank;

	@Temporal(TemporalType.DATE)
	private Date date;
/*
	@Column(name="debit_limit")
	private BigDecimal debitLimit;
*/
	@Column(name="display_name")
	private String displayName;

	private String email;

	@Column(name="email_normalized")
	private String emailNormalized;

	private Boolean employee;

	private String function;

	@Column(name="industry_id")
	private Integer industryId;

	@Column(name="invoice_warn")
	private String invoiceWarn;

	@Column(name="invoice_warn_msg")
	private String invoiceWarnMsg;

	@Column(name="is_company")
	private Boolean isCompany;

	private String lang;

	@Column(name="last_time_entries_checked")
	private Timestamp lastTimeEntriesChecked;

	@Column(name="message_bounce")
	private Integer messageBounce;

	@Column(name="message_main_attachment_id")
	private Integer messageMainAttachmentId;

	private String mobile;

	private String name;

	@Column(name="partner_gid")
	private Integer partnerGid;

	@Column(name="partner_latitude")
	private BigDecimal partnerLatitude;

	@Column(name="partner_longitude")
	private BigDecimal partnerLongitude;

	@Column(name="partner_share")
	private Boolean partnerShare;

	private String phone;

	@Column(name="phone_sanitized")
	private String phoneSanitized;

	private String ref;

	@Column(name="sale_warn")
	private String saleWarn;

	@Column(name="sale_warn_msg")
	private String saleWarnMsg;

	@Column(name="signup_expiration")
	private Timestamp signupExpiration;

	@Column(name="signup_token")
	private String signupToken;

	@Column(name="signup_type")
	private String signupType;

	@Column(name="state_id")
	private Integer stateId;

	private String street;

	private String street2;

	@Column(name="supplier_rank")
	private Integer supplierRank;

	@Column(name="team_id")
	private Integer teamId;

	private Integer title;

	private String type;

	private String tz;

	@Column(name="user_id")
	private Integer userId;

	private String vat;

	private String website;

	@Column(name="write_date")
	private Timestamp writeDate;

	@Column(name="write_uid")
	private Integer writeUid;

	private String zip;

	//bi-directional many-to-one association to PartidakPartida
	@OneToMany(mappedBy="langilea")
	private List<PartidakPartida> partidakPartidas;

	//bi-directional many-to-one association to ResPartner
	@ManyToOne
	@JoinColumn(name="commercial_partner_id")
	private ResPartner resPartner1;

	//bi-directional many-to-one association to ResPartner
	@OneToMany(mappedBy="resPartner1")
	private List<ResPartner> resPartners1;

	//bi-directional many-to-one association to ResPartner
	@ManyToOne
	@JoinColumn(name="parent_id")
	private ResPartner resPartner2;

	//bi-directional many-to-one association to ResPartner
	@OneToMany(mappedBy="resPartner2")
	private List<ResPartner> resPartners2;

	public ResPartner() {
	}

	public ResPartner(int id, String name, String zip, String city, String email, String phone){
		this.id = id;
		this.name = name;
		this.zip = zip;
		this.city = city;
		this.email = email;
		this.phone = phone;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Boolean getActive() {
		return this.active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public String getAdditionalInfo() {
		return this.additionalInfo;
	}

	public void setAdditionalInfo(String additionalInfo) {
		this.additionalInfo = additionalInfo;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Integer getColor() {
		return this.color;
	}

	public void setColor(Integer color) {
		this.color = color;
	}

	public String getComment() {
		return this.comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getCommercialCompanyName() {
		return this.commercialCompanyName;
	}

	public void setCommercialCompanyName(String commercialCompanyName) {
		this.commercialCompanyName = commercialCompanyName;
	}

	public Integer getCompanyId() {
		return this.companyId;
	}

	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}

	public String getCompanyName() {
		return this.companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public Integer getCountryId() {
		return this.countryId;
	}

	public void setCountryId(Integer countryId) {
		this.countryId = countryId;
	}

	public Timestamp getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	public Integer getCreateUid() {
		return this.createUid;
	}

	public void setCreateUid(Integer createUid) {
		this.createUid = createUid;
	}

	/*public double getCreditLimit() {
		return this.creditLimit;
	}

	public void setCreditLimit(double creditLimit) {
		this.creditLimit = creditLimit;
	}
*/
	public Integer getCustomerRank() {
		return this.customerRank;
	}

	public void setCustomerRank(Integer customerRank) {
		this.customerRank = customerRank;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
/*
	public BigDecimal getDebitLimit() {
		return this.debitLimit;
	}

	public void setDebitLimit(BigDecimal debitLimit) {
		this.debitLimit = debitLimit;
	}
*/
	public String getDisplayName() {
		return this.displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmailNormalized() {
		return this.emailNormalized;
	}

	public void setEmailNormalized(String emailNormalized) {
		this.emailNormalized = emailNormalized;
	}

	public Boolean getEmployee() {
		return this.employee;
	}

	public void setEmployee(Boolean employee) {
		this.employee = employee;
	}

	public String getFunction() {
		return this.function;
	}

	public void setFunction(String function) {
		this.function = function;
	}

	public Integer getIndustryId() {
		return this.industryId;
	}

	public void setIndustryId(Integer industryId) {
		this.industryId = industryId;
	}

	public String getInvoiceWarn() {
		return this.invoiceWarn;
	}

	public void setInvoiceWarn(String invoiceWarn) {
		this.invoiceWarn = invoiceWarn;
	}

	public String getInvoiceWarnMsg() {
		return this.invoiceWarnMsg;
	}

	public void setInvoiceWarnMsg(String invoiceWarnMsg) {
		this.invoiceWarnMsg = invoiceWarnMsg;
	}

	public Boolean getIsCompany() {
		return this.isCompany;
	}

	public void setIsCompany(Boolean isCompany) {
		this.isCompany = isCompany;
	}

	public String getLang() {
		return this.lang;
	}

	public void setLang(String lang) {
		this.lang = lang;
	}

	public Timestamp getLastTimeEntriesChecked() {
		return this.lastTimeEntriesChecked;
	}

	public void setLastTimeEntriesChecked(Timestamp lastTimeEntriesChecked) {
		this.lastTimeEntriesChecked = lastTimeEntriesChecked;
	}

	public Integer getMessageBounce() {
		return this.messageBounce;
	}

	public void setMessageBounce(Integer messageBounce) {
		this.messageBounce = messageBounce;
	}

	public Integer getMessageMainAttachmentId() {
		return this.messageMainAttachmentId;
	}

	public void setMessageMainAttachmentId(Integer messageMainAttachmentId) {
		this.messageMainAttachmentId = messageMainAttachmentId;
	}

	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPartnerGid() {
		return this.partnerGid;
	}

	public void setPartnerGid(Integer partnerGid) {
		this.partnerGid = partnerGid;
	}

	public BigDecimal getPartnerLatitude() {
		return this.partnerLatitude;
	}

	public void setPartnerLatitude(BigDecimal partnerLatitude) {
		this.partnerLatitude = partnerLatitude;
	}

	public BigDecimal getPartnerLongitude() {
		return this.partnerLongitude;
	}

	public void setPartnerLongitude(BigDecimal partnerLongitude) {
		this.partnerLongitude = partnerLongitude;
	}

	public Boolean getPartnerShare() {
		return this.partnerShare;
	}

	public void setPartnerShare(Boolean partnerShare) {
		this.partnerShare = partnerShare;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPhoneSanitized() {
		return this.phoneSanitized;
	}

	public void setPhoneSanitized(String phoneSanitized) {
		this.phoneSanitized = phoneSanitized;
	}

	public String getRef() {
		return this.ref;
	}

	public void setRef(String ref) {
		this.ref = ref;
	}

	public String getSaleWarn() {
		return this.saleWarn;
	}

	public void setSaleWarn(String saleWarn) {
		this.saleWarn = saleWarn;
	}

	public String getSaleWarnMsg() {
		return this.saleWarnMsg;
	}

	public void setSaleWarnMsg(String saleWarnMsg) {
		this.saleWarnMsg = saleWarnMsg;
	}

	public Timestamp getSignupExpiration() {
		return this.signupExpiration;
	}

	public void setSignupExpiration(Timestamp signupExpiration) {
		this.signupExpiration = signupExpiration;
	}

	public String getSignupToken() {
		return this.signupToken;
	}

	public void setSignupToken(String signupToken) {
		this.signupToken = signupToken;
	}

	public String getSignupType() {
		return this.signupType;
	}

	public void setSignupType(String signupType) {
		this.signupType = signupType;
	}

	public Integer getStateId() {
		return this.stateId;
	}

	public void setStateId(Integer stateId) {
		this.stateId = stateId;
	}

	public String getStreet() {
		return this.street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getStreet2() {
		return this.street2;
	}

	public void setStreet2(String street2) {
		this.street2 = street2;
	}

	public Integer getSupplierRank() {
		return this.supplierRank;
	}

	public void setSupplierRank(Integer supplierRank) {
		this.supplierRank = supplierRank;
	}

	public Integer getTeamId() {
		return this.teamId;
	}

	public void setTeamId(Integer teamId) {
		this.teamId = teamId;
	}

	public Integer getTitle() {
		return this.title;
	}

	public void setTitle(Integer title) {
		this.title = title;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTz() {
		return this.tz;
	}

	public void setTz(String tz) {
		this.tz = tz;
	}

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getVat() {
		return this.vat;
	}

	public void setVat(String vat) {
		this.vat = vat;
	}

	public String getWebsite() {
		return this.website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public Timestamp getWriteDate() {
		return this.writeDate;
	}

	public void setWriteDate(Timestamp writeDate) {
		this.writeDate = writeDate;
	}

	public Integer getWriteUid() {
		return this.writeUid;
	}

	public void setWriteUid(Integer writeUid) {
		this.writeUid = writeUid;
	}

	public String getZip() {
		return this.zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public List<PartidakPartida> getPartidakPartidas() {
		return this.partidakPartidas;
	}

	public void setPartidakPartidas(List<PartidakPartida> partidakPartidas) {
		this.partidakPartidas = partidakPartidas;
	}

	public PartidakPartida addPartidakPartida(PartidakPartida partidakPartida) {
		getPartidakPartidas().add(partidakPartida);
		partidakPartida.setlangilea(this);

		return partidakPartida;
	}

	public PartidakPartida removePartidakPartida(PartidakPartida partidakPartida) {
		getPartidakPartidas().remove(partidakPartida);
		partidakPartida.setlangilea(null);

		return partidakPartida;
	}

	public ResPartner getResPartner1() {
		return this.resPartner1;
	}

	public void setResPartner1(ResPartner resPartner1) {
		this.resPartner1 = resPartner1;
	}

	public List<ResPartner> getResPartners1() {
		return this.resPartners1;
	}

	public void setResPartners1(List<ResPartner> resPartners1) {
		this.resPartners1 = resPartners1;
	}

	public ResPartner addResPartners1(ResPartner resPartners1) {
		getResPartners1().add(resPartners1);
		resPartners1.setResPartner1(this);

		return resPartners1;
	}

	public ResPartner removeResPartners1(ResPartner resPartners1) {
		getResPartners1().remove(resPartners1);
		resPartners1.setResPartner1(null);

		return resPartners1;
	}

	public ResPartner getResPartner2() {
		return this.resPartner2;
	}

	public void setResPartner2(ResPartner resPartner2) {
		this.resPartner2 = resPartner2;
	}

	public List<ResPartner> getResPartners2() {
		return this.resPartners2;
	}

	public void setResPartners2(List<ResPartner> resPartners2) {
		this.resPartners2 = resPartners2;
	}

	public ResPartner addResPartners2(ResPartner resPartners2) {
		getResPartners2().add(resPartners2);
		resPartners2.setResPartner2(this);

		return resPartners2;
	}

	public ResPartner removeResPartners2(ResPartner resPartners2) {
		getResPartners2().remove(resPartners2);
		resPartners2.setResPartner2(null);

		return resPartners2;
	}


}