package model.jComboBoxModel;

import java.util.List;

public interface ComboBoxModelInterface {

    List<String> dataListForJCBModel(String sql, String col, String... whereClausule);
}
