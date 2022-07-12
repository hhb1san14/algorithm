package com.hhb.algorithm.leetcode;

import java.util.List;

/**
 * @author hhb
 * @date 2022/7/12
 * @description
 */
public class Nodes {
    public int val;
    public List<Nodes> children;

    public Nodes() {
    }

    public Nodes(int _val) {
        val = _val;
    }

    public Nodes(int _val, List<Nodes> _children) {
        val = _val;
        children = _children;
    }
}
