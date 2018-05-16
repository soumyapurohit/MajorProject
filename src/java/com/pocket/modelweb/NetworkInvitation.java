package com.pocket.modelweb;

/**
 *
 * @author hp
 */
public class NetworkInvitation {
    
    private int inviteId,networkId,memberId,sentBy;
    private String title,profilePicMember,profilePicNetwork,fname,lname;

    public NetworkInvitation() {
    }

    public NetworkInvitation(int inviteId, int networkId, int memberId, int sentBy, String title, String profilePicMember, String profilePicNetwork, String fname, String lname) {
        this.inviteId = inviteId;
        this.networkId = networkId;
        this.memberId = memberId;
        this.sentBy = sentBy;
        this.title = title;
        this.profilePicMember = profilePicMember;
        this.profilePicNetwork = profilePicNetwork;
        this.fname = fname;
        this.lname = lname;
    }

    public int getInviteId() {
        return inviteId;
    }

    public void setInviteId(int inviteId) {
        this.inviteId = inviteId;
    }

    public int getNetworkId() {
        return networkId;
    }

    public void setNetworkId(int networkId) {
        this.networkId = networkId;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public int getSentBy() {
        return sentBy;
    }

    public void setSentBy(int sentBy) {
        this.sentBy = sentBy;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getProfilePicMember() {
        return profilePicMember;
    }

    public void setProfilePicMember(String profilePicMember) {
        this.profilePicMember = profilePicMember;
    }

    public String getProfilePicNetwork() {
        return profilePicNetwork;
    }

    public void setProfilePicNetwork(String profilePicNetwork) {
        this.profilePicNetwork = profilePicNetwork;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    @Override
    public String toString() {
        return "NetworkInvitation{" + "inviteId=" + inviteId + ", networkId=" + networkId + ", memberId=" + memberId + ", sentBy=" + sentBy + ", title=" + title + ", profilePicMember=" + profilePicMember + ", profilePicNetwork=" + profilePicNetwork + ", fname=" + fname + ", lname=" + lname + '}';
    }
    
    
    
}
