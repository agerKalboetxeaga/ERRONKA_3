package eus.uni.dam;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the partidak_partida database table.
 * 
 */
@Entity
@Table(name="partidak_partida")
@NamedQuery(name="PartidakPartida.findAll", query="SELECT p FROM PartidakPartida p")
public class PartidakPartida implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	@Column(name="create_date")
	private Timestamp createDate;

	@Column(name="create_uid")
	private Integer createUid;

	private Timestamp date;

	private Integer kills;

	private Integer puntuazioa;

	private String time;

	@Column(name="write_date")
	private Timestamp writeDate;

	@Column(name="write_uid")
	private Integer writeUid;

	//bi-directional many-to-one association to ResPartner
	@ManyToOne
	@JoinColumn(name="res_partner_id")
	private ResPartner langilea;

	public PartidakPartida() {
	}
	public PartidakPartida(int id ,int puntuazioa, int kills, String time,Timestamp date, ResPartner langilea ){
		this.id =id;
		this.puntuazioa = puntuazioa;
		this.kills = kills;
		this.time = time;
		this.date = date;
		this.langilea = langilea;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Timestamp getDate() {
		return this.date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}

	public Integer getKills() {
		return this.kills;
	}

	public void setKills(Integer kills) {
		this.kills = kills;
	}

	public Integer getPuntuazioa() {
		return this.puntuazioa;
	}

	public void setPuntuazioa(Integer puntuazioa) {
		this.puntuazioa = puntuazioa;
	}

	public String getTime() {
		return this.time;
	}

	public void setTime(String time) {
		this.time = time;
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

	public ResPartner getlangilea() {
		return this.langilea;
	}

	public void setlangilea(ResPartner langilea) {
		this.langilea = langilea;
	}

}