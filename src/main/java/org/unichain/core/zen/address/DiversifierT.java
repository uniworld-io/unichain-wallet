package org.unichain.core.zen.address;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.unichain.api.GrpcAPI.DiversifierMessage;
import org.unichain.walletserver.WalletApi;

import java.util.Optional;

@AllArgsConstructor
public class DiversifierT {

  @Setter
  @Getter
  public byte[] data;

  public DiversifierT() {
  }

  public DiversifierT random() {
    Optional<DiversifierMessage> diversifierMessage;
    while ( true ) {
      diversifierMessage = WalletApi.getDiversifier();
      if (diversifierMessage.isPresent()) {
        break;
      }
    }
    this.data = diversifierMessage.get().getD().toByteArray();
    return this;
  }
}
