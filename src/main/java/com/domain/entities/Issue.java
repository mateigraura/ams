package com.domain.entities;

import com.domain.entities.enumerators.IssueCategory;
import com.domain.entities.enumerators.IssueStatus;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
public class Issue {

    Integer id;
    IssueCategory issueCategory;
    IssueStatus issueStatus;
    String passengerName;
    String filedBy;
    Date filedAt;
    String description;
    Integer flightRef;

    public Issue(
            Integer id,
            IssueCategory issueCategory,
            IssueStatus issueStatus,
            String passengerName,
            String filedBy,
            Date filedAt,
            String description,
            Integer flightRef
    ) {
        this.id = id;
        this.issueCategory = issueCategory;
        this.issueStatus = issueStatus;
        this.passengerName = passengerName;
        this.filedBy = filedBy;
        this.filedAt = filedAt;
        this.description = description;
        this.flightRef = flightRef;
    }

    public Issue(
            IssueCategory issueCategory,
            IssueStatus issueStatus,
            String passengerName,
            String filedBy,
            Date filedAt,
            String description,
            Integer flightRef
    ) {
        this.issueCategory = issueCategory;
        this.issueStatus = issueStatus;
        this.passengerName = passengerName;
        this.filedBy = filedBy;
        this.filedAt = filedAt;
        this.description = description;
        this.flightRef = flightRef;
    }
}
