package ua.epam.dana.service;

import ua.epam.dana.dao.impl.MetaDataDaoImpl;
import ua.epam.dana.model.metadata.TableMetaData;

import java.sql.SQLException;
import java.util.List;

public class MetaDataService {
    public List<String> findAllTableName() throws SQLException {
        return new MetaDataDaoImpl().findAllTableName();
    }

    public List<TableMetaData> getTablesStructure() throws SQLException {
        return new MetaDataDaoImpl().getTablesStructure();
    }

}
