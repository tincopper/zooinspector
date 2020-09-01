package org.apache.zookeeper.inspector;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.tree.TreePath;

public class ZooInspectorUtil {

  /**
   * convert TreePath to ZNodePath
   */
  public static String treePathToZnodePath(TreePath treePath) {
    if (treePath == null) {
      return null;
    }

    Object[] objects = treePath.getPath();
    if (objects.length == 1) {
      return "/";
    }

    StringBuilder znodePath = new StringBuilder();
    for (int i = 1; i < objects.length; i++) {
      znodePath.append("/").append(objects[i].toString());
    }
    return znodePath.toString();
  }

  public static List<String> treePathToZnodePath(TreePath[] treePaths) {
    if (treePaths == null || treePaths.length == 0) {
      return Collections.emptyList();
    }

    List<String> znodePaths = new ArrayList<>();
    for (TreePath treePath : treePaths) {
      znodePaths.add(treePathToZnodePath(treePath));
    }
    return znodePaths;
  }
}
