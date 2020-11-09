package com.board.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity //JPA
public class Board {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    /** idx (PK) */
    private Long idx;

    /** title */
    private String title;

    /** contents */
    private String contents;

    /** writer */
    private String writer;

    /** viewCnt */
    private int viewCnt;

    /** noticeYn */
    private String noticeYn;

    /** secretYn */
    private String secretYn;

    /** deleteYn */
    private String deleteYn;



    /** updateTime */
    private LocalDateTime updateTime;

    /** deleteTime */
    private LocalDateTime deleteTime;

    public Long getIdx() {
        return idx;
    }

    public String getTitle() {
        return title;
    }

    public String getContents() {
        return contents;
    }

    public String getWriter() {
        return writer;
    }

    public int getViewCnt() {
        return viewCnt;
    }

    public String getNoticeYn() {
        return noticeYn;
    }

    public String getSecretYn() {
        return secretYn;
    }

    public String getDeleteYn() {
        return deleteYn;
    }


    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public LocalDateTime getDeleteTime() {
        return deleteTime;
    }

    public void setIdx(Long idx) {
        this.idx = idx;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public void setViewCnt(int viewCnt) {
        this.viewCnt = viewCnt;
    }

    public void setNoticeYn(String noticeYn) {
        this.noticeYn = noticeYn;
    }

    public void setSecretYn(String secretYn) {
        this.secretYn = secretYn;
    }

    public void setDeleteYn(String deleteYn) {
        this.deleteYn = deleteYn;
    }


    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    public void setDeleteTime(LocalDateTime deleteTime) {
        this.deleteTime = deleteTime;
    }

}
