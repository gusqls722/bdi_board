package com.board.bdi.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * 새 테이블 모델 클래스.
 * 
 * @author generated by ERMaster
 * @version $Id$
 */
public class CommentInfoVo implements Serializable {

	/** serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** 댓글번호. */
	private Integer cinum;

	/** 댓글등록일. */
	private String cicredat;

	/** 댓글수정일. */
	private String cimodat;

	/** 댓글내용. */
	private String citext;

	/** 새 테이블. */
	private UserInfoVo userInfo;

	/** 새 테이블. */
	private BoardInfoVo boardInfo;

	/**
	 * 생성자.
	 */
	public CommentInfoVo() {
	}

	/**
	 * 댓글번호을 설정합니다..
	 * 
	 * @param cinum
	 *            댓글번호
	 */
	public void setCinum(Integer cinum) {
		this.cinum = cinum;
	}

	/**
	 * 댓글번호을 가져옵니다..
	 * 
	 * @return 댓글번호
	 */
	public Integer getCinum() {
		return this.cinum;
	}


	/**
	 * 댓글등록일을 설정합니다..
	 * 
	 * @param cicredat
	 *            댓글등록일
	 */
	public void setCicredat(String cicredat) {
		this.cicredat = cicredat;
	}

	/**
	 * 댓글등록일을 가져옵니다..
	 * 
	 * @return 댓글등록일
	 */
	public String getCicredat() {
		return this.cicredat;
	}

	/**
	 * 댓글수정일을 설정합니다..
	 * 
	 * @param cimodat
	 *            댓글수정일
	 */
	public void setCimodat(String cimodat) {
		this.cimodat = cimodat;
	}

	/**
	 * 댓글수정일을 가져옵니다..
	 * 
	 * @return 댓글수정일
	 */
	public String getCimodat() {
		return this.cimodat;
	}

	/**
	 * 댓글내용을 설정합니다..
	 * 
	 * @param citext
	 *            댓글내용
	 */
	public void setCitext(String citext) {
		this.citext = citext;
	}

	/**
	 * 댓글내용을 가져옵니다..
	 * 
	 * @return 댓글내용
	 */
	public String getCitext() {
		return this.citext;
	}

	/**
	 * 새 테이블을 설정합니다..
	 * 
	 * @param userInfo
	 *            새 테이블
	 */
	public void setUserInfo(UserInfoVo userInfo) {
		this.userInfo = userInfo;
	}

	/**
	 * 새 테이블을 가져옵니다..
	 * 
	 * @return 새 테이블
	 */
	public UserInfoVo getUserInfo() {
		return this.userInfo;
	}

	/**
	 * 새 테이블을 설정합니다..
	 * 
	 * @param boardInfo
	 *            새 테이블
	 */
	public void setBoardInfo(BoardInfoVo boardInfo) {
		this.boardInfo = boardInfo;
	}

	/**
	 * 새 테이블을 가져옵니다..
	 * 
	 * @return 새 테이블
	 */
	public BoardInfoVo getBoardInfo() {
		return this.boardInfo;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cinum == null) ? 0 : cinum.hashCode());
		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		CommentInfoVo other = (CommentInfoVo) obj;
		if (cinum == null) {
			if (other.cinum != null) {
				return false;
			}
		} else if (!cinum.equals(other.cinum)) {
			return false;
		}
		return true;
	}


	@Override
	public String toString() {
		return "CommentInfoVo [cinum=" + cinum + ", cicredat=" + cicredat + ", cimodat=" + cimodat + ", citext="
				+ citext + ", userInfo=" + userInfo + ", boardInfo=" + boardInfo + "]";
	}
}
