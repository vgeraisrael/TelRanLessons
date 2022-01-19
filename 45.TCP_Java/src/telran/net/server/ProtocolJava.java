package telran.net.server;

import telran.net.RequestJava;
import telran.net.ResponceJava;

public interface ProtocolJava {
    ResponceJava getResponce(RequestJava requestJava);
}
