package com.data.interfaces;

import java.io.IOException;

@FunctionalInterface
public interface FileOperation {
  void run() throws IOException;
}
