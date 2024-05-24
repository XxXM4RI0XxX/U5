package Catalogo.Util;

import Catalogo.CustomExceptions.ProductNotFound;

public interface Menu {

    void execute() throws ProductNotFound;

}
