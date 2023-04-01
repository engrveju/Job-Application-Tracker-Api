package com.jobs.app.config;

import com.jobs.app.model.Applications;

import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.util.*;

public class Codewars {
    public static int pivotIndex(int[] nums) {
        int sum = 0;
        int leftSum = 0;
        for (int num : nums) {
            sum += num;
        }
        for (int i = 0; i < nums.length; i++) {
            if (leftSum == sum - leftSum - nums[i]) {
                return i;
            }
            leftSum += nums[i];
        }
        return -1;
    }

        public static void main(String[] args) {
            System.out.println(pivotIndex(new int[]{1,5,3,7,6,6,2}));
        }
    }