package eus.uni.dam;

import java.io.Serializable;
import javax.persistence.*;



import java.util.Date;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the hr_employee database table.
 * 
 */
@Entity
@Table(name="hr_employee")
@NamedQuery(name="HrEmployee.findAll", query="SELECT h FROM HrEmployee h")
public class HrEmployee implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private Boolean active;

	@Column(name="additional_note")
	private String additionalNote;

	@Column(name="address_home_id")
	private Integer addressHomeId;

	@Column(name="address_id")
	private Integer addressId;

	@Column(name="bank_account_id")
	private Integer bankAccountId;

	private String barcode;

	@Temporal(TemporalType.DATE)
	private Date birthday;

	private String certificate;

	private Integer children;

	private Integer color;

	@Column(name="company_id")
	private Integer companyId;

	@Column(name="country_id")
	private Integer countryId;

	@Column(name="country_of_birth")
	private Integer countryOfBirth;

	@Column(name="create_date")
	private Timestamp createDate;

	@Column(name="create_uid")
	private Integer createUid;

	@Column(name="department_id")
	private Integer departmentId;

	@Temporal(TemporalType.DATE)
	@Column(name="departure_date")
	private Date departureDate;

	@Column(name="departure_description")
	private String departureDescription;

	@Column(name="departure_reason")
	private String departureReason;

	@Column(name="emergency_contact")
	private String emergencyContact;

	@Column(name="emergency_phone")
	private String emergencyPhone;

	private String gender;

	@Column(name="identification_id")
	private String identificationId;

	@Column(name="job_id")
	private Integer jobId;

	@Column(name="job_title")
	private String jobTitle;

	@Column(name="km_home_work")
	private Integer kmHomeWork;

	private String marital;

	@Column(name="message_main_attachment_id")
	private Integer messageMainAttachmentId;

	@Column(name="mobile_phone")
	private String mobilePhone;

	private String name;

	private String notes;

	@Column(name="passport_id")
	private String passportId;

	@Column(name="permit_no")
	private String permitNo;

	private String pin;

	@Column(name="place_of_birth")
	private String placeOfBirth;

	@Column(name="resource_calendar_id")
	private Integer resourceCalendarId;

	@Column(name="resource_id")
	private Integer resourceId;

	private String sinid;

	@Temporal(TemporalType.DATE)
	@Column(name="spouse_birthdate")
	private Date spouseBirthdate;

	@Column(name="spouse_complete_name")
	private String spouseCompleteName;

	private String ssnid;

	@Column(name="study_field")
	private String studyField;

	@Column(name="study_school")
	private String studySchool;

	@Column(name="user_id")
	private Integer userId;

	@Temporal(TemporalType.DATE)
	@Column(name="visa_expire")
	private Date visaExpire;

	@Column(name="visa_no")
	private String visaNo;

	@Column(name="work_email")
	private String workEmail;

	@Column(name="work_location")
	private String workLocation;

	@Column(name="work_phone")
	private String workPhone;

	@Column(name="write_date")
	private Timestamp writeDate;

	@Column(name="write_uid")
	private Integer writeUid;

	//bi-directional many-to-one association to HrEmployee
	@ManyToOne
	@JoinColumn(name="coach_id")
	private HrEmployee hrEmployee1;

	//bi-directional many-to-one association to HrEmployee
	@OneToMany(mappedBy="hrEmployee1")
	private List<HrEmployee> hrEmployees1;

	//bi-directional many-to-one association to HrEmployee
	@ManyToOne
	@JoinColumn(name="parent_id")
	private HrEmployee hrEmployee2;

	//bi-directional many-to-one association to HrEmployee
	@OneToMany(mappedBy="hrEmployee2")
	private List<HrEmployee> hrEmployees2;

	//bi-directional many-to-one association to PartidakPartida
	@OneToMany(mappedBy="hrEmployee")
	private List<PartidakPartida> partidakPartidas;

	public HrEmployee() {
	}
	public HrEmployee(int id, String name, String jobTitle, String workPhone, String workEmail) {
		this.id = id;
		this.name = name;
		this.jobTitle = jobTitle;
		this.workPhone = workPhone;
		this.workEmail = workEmail;
		
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

	public String getAdditionalNote() {
		return this.additionalNote;
	}

	public void setAdditionalNote(String additionalNote) {
		this.additionalNote = additionalNote;
	}

	public Integer getAddressHomeId() {
		return this.addressHomeId;
	}

	public void setAddressHomeId(Integer addressHomeId) {
		this.addressHomeId = addressHomeId;
	}

	public Integer getAddressId() {
		return this.addressId;
	}

	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}

	public Integer getBankAccountId() {
		return this.bankAccountId;
	}

	public void setBankAccountId(Integer bankAccountId) {
		this.bankAccountId = bankAccountId;
	}

	public String getBarcode() {
		return this.barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	public Date getBirthday() {
		return this.birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getCertificate() {
		return this.certificate;
	}

	public void setCertificate(String certificate) {
		this.certificate = certificate;
	}

	public Integer getChildren() {
		return this.children;
	}

	public void setChildren(Integer children) {
		this.children = children;
	}

	public Integer getColor() {
		return this.color;
	}

	public void setColor(Integer color) {
		this.color = color;
	}

	public Integer getCompanyId() {
		return this.companyId;
	}

	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}

	public Integer getCountryId() {
		return this.countryId;
	}

	public void setCountryId(Integer countryId) {
		this.countryId = countryId;
	}

	public Integer getCountryOfBirth() {
		return this.countryOfBirth;
	}

	public void setCountryOfBirth(Integer countryOfBirth) {
		this.countryOfBirth = countryOfBirth;
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

	public Integer getDepartmentId() {
		return this.departmentId;
	}

	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}

	public Date getDepartureDate() {
		return this.departureDate;
	}

	public void setDepartureDate(Date departureDate) {
		this.departureDate = departureDate;
	}

	public String getDepartureDescription() {
		return this.departureDescription;
	}

	public void setDepartureDescription(String departureDescription) {
		this.departureDescription = departureDescription;
	}

	public String getDepartureReason() {
		return this.departureReason;
	}

	public void setDepartureReason(String departureReason) {
		this.departureReason = departureReason;
	}

	public String getEmergencyContact() {
		return this.emergencyContact;
	}

	public void setEmergencyContact(String emergencyContact) {
		this.emergencyContact = emergencyContact;
	}

	public String getEmergencyPhone() {
		return this.emergencyPhone;
	}

	public void setEmergencyPhone(String emergencyPhone) {
		this.emergencyPhone = emergencyPhone;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getIdentificationId() {
		return this.identificationId;
	}

	public void setIdentificationId(String identificationId) {
		this.identificationId = identificationId;
	}

	public Integer getJobId() {
		return this.jobId;
	}

	public void setJobId(Integer jobId) {
		this.jobId = jobId;
	}

	public String getJobTitle() {
		return this.jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public Integer getKmHomeWork() {
		return this.kmHomeWork;
	}

	public void setKmHomeWork(Integer kmHomeWork) {
		this.kmHomeWork = kmHomeWork;
	}

	public String getMarital() {
		return this.marital;
	}

	public void setMarital(String marital) {
		this.marital = marital;
	}

	public Integer getMessageMainAttachmentId() {
		return this.messageMainAttachmentId;
	}

	public void setMessageMainAttachmentId(Integer messageMainAttachmentId) {
		this.messageMainAttachmentId = messageMainAttachmentId;
	}

	public String getMobilePhone() {
		return this.mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNotes() {
		return this.notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public String getPassportId() {
		return this.passportId;
	}

	public void setPassportId(String passportId) {
		this.passportId = passportId;
	}

	public String getPermitNo() {
		return this.permitNo;
	}

	public void setPermitNo(String permitNo) {
		this.permitNo = permitNo;
	}

	public String getPin() {
		return this.pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

	public String getPlaceOfBirth() {
		return this.placeOfBirth;
	}

	public void setPlaceOfBirth(String placeOfBirth) {
		this.placeOfBirth = placeOfBirth;
	}

	public Integer getResourceCalendarId() {
		return this.resourceCalendarId;
	}

	public void setResourceCalendarId(Integer resourceCalendarId) {
		this.resourceCalendarId = resourceCalendarId;
	}

	public Integer getResourceId() {
		return this.resourceId;
	}

	public void setResourceId(Integer resourceId) {
		this.resourceId = resourceId;
	}

	public String getSinid() {
		return this.sinid;
	}

	public void setSinid(String sinid) {
		this.sinid = sinid;
	}

	public Date getSpouseBirthdate() {
		return this.spouseBirthdate;
	}

	public void setSpouseBirthdate(Date spouseBirthdate) {
		this.spouseBirthdate = spouseBirthdate;
	}

	public String getSpouseCompleteName() {
		return this.spouseCompleteName;
	}

	public void setSpouseCompleteName(String spouseCompleteName) {
		this.spouseCompleteName = spouseCompleteName;
	}

	public String getSsnid() {
		return this.ssnid;
	}

	public void setSsnid(String ssnid) {
		this.ssnid = ssnid;
	}

	public String getStudyField() {
		return this.studyField;
	}

	public void setStudyField(String studyField) {
		this.studyField = studyField;
	}

	public String getStudySchool() {
		return this.studySchool;
	}

	public void setStudySchool(String studySchool) {
		this.studySchool = studySchool;
	}

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Date getVisaExpire() {
		return this.visaExpire;
	}

	public void setVisaExpire(Date visaExpire) {
		this.visaExpire = visaExpire;
	}

	public String getVisaNo() {
		return this.visaNo;
	}

	public void setVisaNo(String visaNo) {
		this.visaNo = visaNo;
	}

	public String getWorkEmail() {
		return this.workEmail;
	}

	public void setWorkEmail(String workEmail) {
		this.workEmail = workEmail;
	}

	public String getWorkLocation() {
		return this.workLocation;
	}

	public void setWorkLocation(String workLocation) {
		this.workLocation = workLocation;
	}

	public String getWorkPhone() {
		return this.workPhone;
	}

	public void setWorkPhone(String workPhone) {
		this.workPhone = workPhone;
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

	public HrEmployee getHrEmployee1() {
		return this.hrEmployee1;
	}

	public void setHrEmployee1(HrEmployee hrEmployee1) {
		this.hrEmployee1 = hrEmployee1;
	}

	public List<HrEmployee> getHrEmployees1() {
		return this.hrEmployees1;
	}

	public void setHrEmployees1(List<HrEmployee> hrEmployees1) {
		this.hrEmployees1 = hrEmployees1;
	}

	public HrEmployee addHrEmployees1(HrEmployee hrEmployees1) {
		getHrEmployees1().add(hrEmployees1);
		hrEmployees1.setHrEmployee1(this);

		return hrEmployees1;
	}

	public HrEmployee removeHrEmployees1(HrEmployee hrEmployees1) {
		getHrEmployees1().remove(hrEmployees1);
		hrEmployees1.setHrEmployee1(null);

		return hrEmployees1;
	}

	public HrEmployee getHrEmployee2() {
		return this.hrEmployee2;
	}

	public void setHrEmployee2(HrEmployee hrEmployee2) {
		this.hrEmployee2 = hrEmployee2;
	}

	public List<HrEmployee> getHrEmployees2() {
		return this.hrEmployees2;
	}

	public void setHrEmployees2(List<HrEmployee> hrEmployees2) {
		this.hrEmployees2 = hrEmployees2;
	}

	public HrEmployee addHrEmployees2(HrEmployee hrEmployees2) {
		getHrEmployees2().add(hrEmployees2);
		hrEmployees2.setHrEmployee2(this);

		return hrEmployees2;
	}

	public HrEmployee removeHrEmployees2(HrEmployee hrEmployees2) {
		getHrEmployees2().remove(hrEmployees2);
		hrEmployees2.setHrEmployee2(null);

		return hrEmployees2;
	}

	public List<PartidakPartida> getPartidakPartidas() {
		return this.partidakPartidas;
	}

	public void setPartidakPartidas(List<PartidakPartida> partidakPartidas) {
		this.partidakPartidas = partidakPartidas;
	}

	public PartidakPartida addPartidakPartida(PartidakPartida partidakPartida) {
		getPartidakPartidas().add(partidakPartida);
		partidakPartida.setHrEmployee(this);

		return partidakPartida;
	}

	public PartidakPartida removePartidakPartida(PartidakPartida partidakPartida) {
		getPartidakPartidas().remove(partidakPartida);
		partidakPartida.setHrEmployee(null);

		return partidakPartida;
	}

}