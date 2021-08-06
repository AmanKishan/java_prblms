package com.helpingduck.loadbalance.model;


import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ServerDetails {
	private String serverIp;
}
