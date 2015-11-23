package zebpay.dhruvil.com.zebpaydemo.models;

import java.util.List;

/**
 * Created by dhruvil on 23/11/15.
 */
public class ActivityFeedPojo {


    private String returncode;
    /**
     * AcitvityType : ​10
     * SourceImageUrl :
     * Title : Santosh joins Zebpay
     * Description : Welcome Santosh, India
     * Time : 2015-11-23T09:50:44
     * RefNumber : 635838690474012174
     * Name : Santosh
     * RefGuid : 7ca72987-ce5d-4c18-9039-6d9f1134dab7
     * PaymentTypeId : null
     * PaymentTypeGuid : null
     */

    private List<ActivityFeedEntity> activityFeed;

    public void setReturncode(String returncode) {
        this.returncode = returncode;
    }

    public void setActivityFeed(List<ActivityFeedEntity> activityFeed) {
        this.activityFeed = activityFeed;
    }

    public String getReturncode() {
        return returncode;
    }

    public List<ActivityFeedEntity> getActivityFeed() {
        return activityFeed;
    }

    public static class ActivityFeedEntity {
        private String AcitvityType;
        private String SourceImageUrl;
        private String Title;
        private String Description;
        private String Time;
        private String RefNumber;
        private String Name;
        private String RefGuid;
        private Object PaymentTypeId;
        private Object PaymentTypeGuid;

        public void setAcitvityType(String AcitvityType) {
            this.AcitvityType = AcitvityType;
        }

        public void setSourceImageUrl(String SourceImageUrl) {
            this.SourceImageUrl = SourceImageUrl;
        }

        public void setTitle(String Title) {
            this.Title = Title;
        }

        public void setDescription(String Description) {
            this.Description = Description;
        }

        public void setTime(String Time) {
            this.Time = Time;
        }

        public void setRefNumber(String RefNumber) {
            this.RefNumber = RefNumber;
        }

        public void setName(String Name) {
            this.Name = Name;
        }

        public void setRefGuid(String RefGuid) {
            this.RefGuid = RefGuid;
        }

        public void setPaymentTypeId(Object PaymentTypeId) {
            this.PaymentTypeId = PaymentTypeId;
        }

        public void setPaymentTypeGuid(Object PaymentTypeGuid) {
            this.PaymentTypeGuid = PaymentTypeGuid;
        }

        public String getAcitvityType() {
            return AcitvityType;
        }

        public String getSourceImageUrl() {
            return SourceImageUrl;
        }

        public String getTitle() {
            return Title;
        }

        public String getDescription() {
            return Description;
        }

        public String getTime() {
            return Time;
        }

        public String getRefNumber() {
            return RefNumber;
        }

        public String getName() {
            return Name;
        }

        public String getRefGuid() {
            return RefGuid;
        }

        public Object getPaymentTypeId() {
            return PaymentTypeId;
        }

        public Object getPaymentTypeGuid() {
            return PaymentTypeGuid;
        }
    }
}
