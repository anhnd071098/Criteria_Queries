package kr.company.wooseok.cms.config;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

public class Config {
    private String cf_address;
    private String cf_tel;
    private String cf_fax;
    private String cf_license;
    private String cf_location;
    private int cf_logo_header;
    private int cf_logo_footer;
}
