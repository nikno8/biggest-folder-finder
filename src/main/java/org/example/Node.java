package org.example;

import java.io.File;
import java.util.ArrayList;


public class Node {

    private File folder;
    private ArrayList<Node> children;

    private long size;

    private int level = 0;

    public Node(File folder) {
        this.folder = folder;
        children = new ArrayList<>();
    }

    public File getFolder() {
        return folder;
    }

    public void addChild(Node node) {
        node.setLevel(level + 1);
        children.add(node);
    }

    private void setLevel(int level) {
        this.level = level;
    }

    public ArrayList<Node> getChildren() {
        return children;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public long getSize() {
        return size;
    }


    public String toString(long sizeLimit) {
        StringBuilder builder = new StringBuilder();
        String size = SizeCalculator.getHumanReadableSize(getSize());
        builder.append(folder.getName() + " - " + size + "\n");
        for (Node child : children) {
            if (child.getSize() >= sizeLimit) {
                builder.append("  ".repeat(level + 1) + child.toString(sizeLimit));
            }
        }

        return builder.toString();
    }

}
