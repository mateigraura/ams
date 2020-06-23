package com.domain.repositories;

import com.business.repositories.IssuesRepository;
import com.domain.entities.Issue;
import com.domain.entities.enumerators.IssueCategory;
import com.domain.entities.enumerators.IssueStatus;
import com.domain.repositories.base.BaseRepository;
import com.presentation.config.DbConnection;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class IssuesRepositoryImpl
        extends BaseRepository
        implements IssuesRepository {

    public IssuesRepositoryImpl() throws Exception {
        super(DbConnection.getInstance().getConnection());
    }

    @Override
    public Issue get(Integer id) throws Exception {
        Object[] params = {id};
        ResultSet resultSet = executionResult("{call getIssueById(?)}", params);

        if (!resultSet.isBeforeFirst()) {
            throw new Exception("No issue found for this id !");
        } else {
            resultSet.next();
            return new Issue(
                    resultSet.getInt(1),
                    IssueCategory.getEnum(resultSet.getInt(2)),
                    IssueStatus.getEnum(resultSet.getInt(3)),
                    resultSet.getString(4),
                    resultSet.getString(5),
                    resultSet.getDate(6),
                    resultSet.getString(7),
                    resultSet.getInt(8)
            );
        }
    }

    @Override
    public List<Issue> getMany() throws Exception {
        ResultSet resultSet = executionResult("{call getIssues()}", null);

        if (!resultSet.isBeforeFirst()) {
            throw new Exception("No airlines found !");
        } else {
            List<Issue> issues = new ArrayList<>();
            while (resultSet.next()) {
                issues.add(new Issue(
                        resultSet.getInt(1),
                        IssueCategory.getEnum(resultSet.getInt(2)),
                        IssueStatus.getEnum(resultSet.getInt(3)),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getDate(6),
                        resultSet.getString(7),
                        resultSet.getInt(8)
                ));
            }
            return issues;
        }
    }

    @Override
    public Issue update(Issue issue) throws Exception {
        Object[] params = {
                issue.getId(),
                issue.getIssueCategory().getValue(),
                issue.getIssueStatus().getValue(),
                issue.getDescription()
        };
        ResultSet resultSet = executionResult("{call editIssue(?, ?, ?, ?)}", params);
        if (!resultSet.isBeforeFirst()) {
            throw new Exception("No issue found for this id !");
        } else {
            resultSet.next();
            return new Issue(
                    resultSet.getInt(1),
                    IssueCategory.getEnum(resultSet.getInt(2)),
                    IssueStatus.getEnum(resultSet.getInt(3)),
                    resultSet.getString(4),
                    resultSet.getString(5),
                    resultSet.getDate(6),
                    resultSet.getString(7),
                    resultSet.getInt(8)
            );
        }
    }

    @Override
    public Issue remove(Issue issue) throws Exception {
        throw new Exception("Not impl");
    }

    @Override
    public Issue insert(Issue issue) throws Exception {
        Object[] params = {
                issue.getIssueCategory().getValue(),
                issue.getIssueStatus().getValue(),
                issue.getPassengerName(),
                issue.getFiledBy(),
                issue.getFiledAt(),
                issue.getDescription(),
                issue.getFlightRef()
        };

        ResultSet resultSet = executionResult("{call addIssue(?, ?, ?, ?, ?, ?, ?)}", params);

        if (!resultSet.isBeforeFirst()) {
            throw new Exception("Couldn't insert new issue");
        } else {
            resultSet.next();
            issue.setId(resultSet.getInt(1));
            return issue;
        }
    }
}
