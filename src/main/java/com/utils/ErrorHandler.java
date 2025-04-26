package com.utils;

import com.data.interfaces.FileOperation;

public class ErrorHandler {
  public static void ExecuteLogic(FileOperation fileOperation) {
    try {
      fileOperation.run();
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
}
