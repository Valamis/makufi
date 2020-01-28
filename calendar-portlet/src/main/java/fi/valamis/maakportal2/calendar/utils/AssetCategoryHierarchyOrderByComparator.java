package fi.valamis.maakportal2.calendar.utils;

import com.liferay.asset.kernel.model.AssetCategory;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.util.OrderByComparator;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class AssetCategoryHierarchyOrderByComparator extends OrderByComparator<AssetCategory> {
    @Override
    public int compare(AssetCategory o1, AssetCategory o2) {
        return getPath(o1).compareTo(getPath(o2));
    }

    private String getPath(AssetCategory category) {
        try {
            List<String> categories = new ArrayList<>();
            category.getAncestors().forEach(ancestorCategory -> categories.add(ancestorCategory.getName()));
            categories.add(category.getName());
            return StringUtils.join(categories, "/");
        } catch (PortalException e) {
            return "";
        }
    }
}
