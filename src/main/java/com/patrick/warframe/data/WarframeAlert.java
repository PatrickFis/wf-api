package com.patrick.warframe.data;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.google.gson.annotations.SerializedName;

public class WarframeAlert {
	@SerializedName("_id")
	public GenericID id;
	@SerializedName("Activation")
	public MissionTimer startTime;
	@SerializedName("Expiry")
	public MissionTimer endTime;
	@SerializedName("MissionInfo")
	public MissionInfo missionInfo;
	
	public WarframeAlert() {
		
	}
	
	@Override
	public String toString() {
		return new ToStringBuilder(this).append(id).append(startTime).append(endTime).append(missionInfo).toString();
	}
//	@SerializedName("_id")
//	public id id;
//	@SerializedName("Activation")
//	public Activation startTime;
//	@SerializedName("Expiry")
//	public Expiry expiry;
//	@SerializedName("MissionInfo")
//	public MissionInfo missionInfo;
//
////	@Override
////	public String toString() {
////		return new ToStringBuilder(this).append(id).append(startTime).append(expiry).append(missionInfo).toString();
////	}
//	
//	static class id {
//		@SerializedName("$oid")
//		public String id;
//
//		public id() {
//
//		}
//		
////		@Override
////		public String toString() {
////			return new ToStringBuilder(this).append(id).toString();
////		}
//	}
//
//	static class Activation {
//		@SerializedName("$date")
//		public Date date;
//
//		public Activation() {
//
//		}
//		
////		@Override
////		public String toString() {
////			return new ToStringBuilder(this).append(date).toString();
////		}
//	}
//
//	static class Expiry {
//		@SerializedName("$date")
//		public Date date;
//
//		public Expiry() {
//
//		}
//		
////		@Override
////		public String toString() {
////			return new ToStringBuilder(this).append(date).toString();
////		}
//	}
//
//	static class Date {
//		@SerializedName("$numberLong")
//		public long numberLong;
//
//		public Date() {
//
//		}
//		
////		@Override
////		public String toString() {
////			return new ToStringBuilder(this).append(numberLong).toString();
////		}
//	}
//
//	static class MissionInfo {
//		public String missionType;
//		public String faction;
//		public String location;
//		public String levelOverride;
//		public String enemySpec;
//		public String extraEnemySpec;
//		public int minEnemyLevel;
//		public int maxEnemeyLevel;
//		public int difficulty;
//		public MissionReward missionReward;
//
//		public MissionInfo() {
//
//		}
//		
////		@Override
////		public String toString() {
////			return new ToStringBuilder(this).append(missionType).append(faction).append(location).append(levelOverride)
////					.append(enemySpec).append(extraEnemySpec).append(minEnemyLevel).append(maxEnemeyLevel)
////					.append(difficulty).append(missionReward).toString();
////		}
//	}
//
//	static class MissionReward {
//		public int credits;
//		@SerializedName("countedItems")
//		public List<?> countedItems;
//		@SerializedName("items")
//		public List<?> items;
//
//		public MissionReward() {
//
//		}
//		
////		@Override
////		public String toString() {
////			return new ToStringBuilder(this).append(credits).append(countedItems).append(items).toString();
////		}
//	}
}
