/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fun.exceptions;

import java.io.IOException;
import java.util.logging.Logger;

/**
 *
 * @author Juned
 */
public class MyException {

//  private static final Logger log = Logger.getLogger(null);

  private final BookService bookService = new BookService();

  public void alpha() { beta(); }

  private void beta() { gamma(); }

  private void gamma() {
    try {
      bookService.delta();
    } catch (Exception e) {
      throw new RuntimeException("Sorry, try again later", e);
    }
  }

  public static void main(String[] args) {
    try {
      new MyException().alpha();
    } catch (Exception e) {
       e.printStackTrace();
    }
  }
}

class BookService {

  private final BookDao bookDao = new BookDao();

  public void delta() { epsilon(); }

  private void epsilon() { zeta(); }

  private void zeta() {
    try {
      bookDao.eta();
    } catch (Exception e) {
      throw new RuntimeException("Unable to save order", e);
    }
  }
}

class BookDao {

  public void eta() { theta(); }

  private void theta() { iota(); }

  public void iota() {
    try {
        System.out.println("its here");
      throw new RuntimeException("Omega server not available");
    } catch (Exception e) {
      throw new RuntimeException("Database problem", e);
    }
  }
}