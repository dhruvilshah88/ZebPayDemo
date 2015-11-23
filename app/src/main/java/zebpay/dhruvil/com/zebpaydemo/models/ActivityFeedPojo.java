package zebpay.dhruvil.com.zebpaydemo.models;

import java.util.List;

/**
 * Created by dhruvil on 23/11/15.
 */
public class ActivityFeedPojo {
    /**
     * activityFeed : [{"AcitvityType":"\u200b10","SourceImageUrl":"","Title":"Santosh joins Zebpay","Description":"Welcome Santosh, India","Time":"2015-11-23T09:50:44","RefNumber":"635838690474012174","Name":"Santosh","RefGuid":"7ca72987-ce5d-4c18-9039-6d9f1134dab7","PaymentTypeId":null,"PaymentTypeGuid":null},{"AcitvityType":"\u200b10","SourceImageUrl":"","Title":"Austin joins Zebpay","Description":"Welcome Austin, India","Time":"2015-11-23T09:50:34","RefNumber":"635838690386267226","Name":"Austin","RefGuid":"f9fdd9fa-0c8e-4445-8f11-cf49d15714fb","PaymentTypeId":null,"PaymentTypeGuid":null},{"AcitvityType":"\u200b40","SourceImageUrl":null,"Title":"Gaurav sent bits to a bitcoin address","Description":"","Time":"2015-11-23T09:49:07","RefNumber":"635838689493918750","Name":"Gaurav","RefGuid":"696cb7b0-b53b-4780-9ce4-b047e7dbcda7","PaymentTypeId":null,"PaymentTypeGuid":null},{"AcitvityType":"\u200b60","SourceImageUrl":null,"Title":"UDAY received bits","Description":"","Time":"2015-11-23T09:46:58","RefNumber":"635838688202873918","Name":"UDAY","RefGuid":"be2db440-907f-4535-8aa0-da95f99a7316","PaymentTypeId":null,"PaymentTypeGuid":null},{"AcitvityType":"\u200b70","SourceImageUrl":null,"Title":"Shashikant sold bits","Description":"Cha ching","Time":"2015-11-23T09:46:04","RefNumber":"635838687655760705","Name":"Shashikant","RefGuid":"0cf473a2-fe08-4558-a8eb-0f80562e8beb","PaymentTypeId":null,"PaymentTypeGuid":null},{"AcitvityType":"\u200b70","SourceImageUrl":null,"Title":"Mandeep sold bits","Description":"Cha ching","Time":"2015-11-23T09:45:59","RefNumber":"635838687612323612","Name":"Mandeep","RefGuid":"5e6c7ad3-dd39-49a1-934f-76d1cba8bb6a","PaymentTypeId":null,"PaymentTypeGuid":null},{"AcitvityType":"\u200b70","SourceImageUrl":null,"Title":"Arya sold bits","Description":"Cha ching","Time":"2015-11-23T09:45:52","RefNumber":"635838687543787919","Name":"Arya","RefGuid":"881bc876-92a8-4070-a0be-e292564d76a0","PaymentTypeId":null,"PaymentTypeGuid":null},{"AcitvityType":"\u200b70","SourceImageUrl":null,"Title":"Mahesh sold bits","Description":"Cha ching","Time":"2015-11-23T09:45:45","RefNumber":"635838687477207378","Name":"Mahesh","RefGuid":"f622c84f-ebd5-4ea7-a977-181e6b79432a","PaymentTypeId":null,"PaymentTypeGuid":null},{"AcitvityType":"\u200b70","SourceImageUrl":null,"Title":"Tejas sold bits","Description":"Cha ching","Time":"2015-11-23T09:45:35","RefNumber":"635838687361374393","Name":"Tejas","RefGuid":"aa64c32c-b688-42a4-b2b9-445b054f9d96","PaymentTypeId":null,"PaymentTypeGuid":null},{"AcitvityType":"\u200b70","SourceImageUrl":null,"Title":"Hesham sold bits","Description":"Cha ching","Time":"2015-11-23T09:45:28","RefNumber":"635838687352312303","Name":"Hesham","RefGuid":"b8114b31-b7f8-41c7-ac1e-21fd142ae57e","PaymentTypeId":null,"PaymentTypeGuid":null},{"AcitvityType":"\u200b70","SourceImageUrl":null,"Title":"Disha sold bits","Description":"Cha ching","Time":"2015-11-23T09:44:58","RefNumber":"635838687008190324","Name":"Disha","RefGuid":"f5db1b3b-ed6c-4851-b957-a1ec2dd0d3a1","PaymentTypeId":null,"PaymentTypeGuid":null},{"AcitvityType":"\u200b70","SourceImageUrl":"https://static.zebpay.com/profilepics/37108c12-7df8-4cbc-b781-1ed74d2271c8_0.png","Title":"Vivekanand sold bits","Description":"Cha ching","Time":"2015-11-23T09:44:52","RefNumber":"635838686937291555","Name":"Vivekanand","RefGuid":"38fa3644-c8ce-4319-9e54-923afac90711","PaymentTypeId":null,"PaymentTypeGuid":null},{"AcitvityType":"\u200b10","SourceImageUrl":"","Title":"Raju joins Zebpay","Description":"Welcome Raju, India","Time":"2015-11-23T09:35:15","RefNumber":"635838681183408784","Name":"Raju","RefGuid":"e8bd764c-4570-4a47-adb0-c232ad3b451b","PaymentTypeId":null,"PaymentTypeGuid":null},{"AcitvityType":"\u200b40","SourceImageUrl":"https://static.zebpay.com/profilepics/b59c2924-4308-4234-8c55-fb281c2e5f98_0.png","Title":"தமிழ் sent bits to a bitcoin address","Description":"","Time":"2015-11-23T09:31:50","RefNumber":"635838679122321258","Name":"தமிழ்","RefGuid":"33ad91cd-560c-49df-b98b-0cfa5de76db1","PaymentTypeId":null,"PaymentTypeGuid":null},{"AcitvityType":"\u200b60","SourceImageUrl":"https://static.zebpay.com/profilepics/881772c0-b707-46b7-bcbc-ded0cc48d115_0.png","Title":"Benudhar received bits","Description":"","Time":"2015-11-23T09:23:57","RefNumber":"635838674434594623","Name":"Benudhar","RefGuid":"bfb8887a-166c-4a8a-8690-0dffb708aa2e","PaymentTypeId":null,"PaymentTypeGuid":null},{"AcitvityType":"\u200b60","SourceImageUrl":null,"Title":"Chaitanya received bits","Description":"","Time":"2015-11-23T09:23:57","RefNumber":"635838674391271218","Name":"Chaitanya","RefGuid":"8f665985-ed28-41fd-96e5-8827c98091a5","PaymentTypeId":null,"PaymentTypeGuid":null},{"AcitvityType":"\u200b10","SourceImageUrl":"https://static.zebpay.com/images/zebpay_0.png","Title":"A user from India joined Zebpay","Description":"Welcome to Zebpay.","Time":"2015-11-23T09:23:36","RefNumber":"635838674188668095","Name":null,"RefGuid":"c268157c-8e28-4d3a-95d6-aec939fa8271","PaymentTypeId":null,"PaymentTypeGuid":null},{"AcitvityType":"\u200b70","SourceImageUrl":null,"Title":"Ziyad bought bits","Description":"Cha ching","Time":"2015-11-23T09:22:24","RefNumber":"635838673448866581","Name":"Ziyad","RefGuid":"6f8978ff-ed9c-4147-8328-f0ea2dc00575","PaymentTypeId":null,"PaymentTypeGuid":null},{"AcitvityType":"\u200b10","SourceImageUrl":"https://static.zebpay.com/images/zebpay_0.png","Title":"A user from India joined Zebpay","Description":"Welcome to Zebpay.","Time":"2015-11-23T09:20:35","RefNumber":"635838672368970692","Name":null,"RefGuid":"64b7c00b-586d-41fa-b05f-f907df9104f7","PaymentTypeId":null,"PaymentTypeGuid":null},{"AcitvityType":"\u200b50","SourceImageUrl":"https://static.zebpay.com/images/f2e7f399-bfd3-4986-bf55-e1ad304aaf98_0.png","Title":"Mahendra sent a magic moment to Dhruvil","Description":"A Thumbs Up","Time":"2015-11-23T09:20:20","RefNumber":"635838672208578685","Name":"Mahendra","RefGuid":"35807117-df4d-42ac-a299-4fb1e1719c47","PaymentTypeId":null,"PaymentTypeGuid":null},{"AcitvityType":"\u200b60","SourceImageUrl":"https://static.zebpay.com/profilepics/881772c0-b707-46b7-bcbc-ded0cc48d115_0.png","Title":"Benudhar received bits","Description":"","Time":"2015-11-23T09:19:26","RefNumber":"635838671676148863","Name":"Benudhar","RefGuid":"21d2fd02-f68e-4ac8-9f54-a6f4e35cd339","PaymentTypeId":null,"PaymentTypeGuid":null},{"AcitvityType":"\u200b60","SourceImageUrl":null,"Title":"Mandeep received bits","Description":"","Time":"2015-11-23T09:19:26","RefNumber":"635838671675211756","Name":"Mandeep","RefGuid":"267cc0fc-1bf8-4f29-ba29-64e6bc66a0fe","PaymentTypeId":null,"PaymentTypeGuid":null},{"AcitvityType":"\u200b60","SourceImageUrl":null,"Title":"Mandeep received bits","Description":"","Time":"2015-11-23T09:19:26","RefNumber":"635838671674117556","Name":"Mandeep","RefGuid":"53668d07-ab95-42e0-a0c0-0f479b2e693b","PaymentTypeId":null,"PaymentTypeGuid":null},{"AcitvityType":"\u200b60","SourceImageUrl":null,"Title":"Shashikant received bits","Description":"","Time":"2015-11-23T09:19:26","RefNumber":"635838671673023797","Name":"Shashikant","RefGuid":"f37025db-dd0d-44e6-b980-c857d9056db4","PaymentTypeId":null,"PaymentTypeGuid":null},{"AcitvityType":"\u200b10","SourceImageUrl":"","Title":"Dhruvil joins Zebpay","Description":"Welcome Dhruvil, India","Time":"2015-11-23T09:17:05","RefNumber":"635838670291497462","Name":"Dhruvil","RefGuid":"003faa7c-6f0a-4458-ad13-eecaed1bcd68","PaymentTypeId":null,"PaymentTypeGuid":null},{"AcitvityType":"\u200b40","SourceImageUrl":null,"Title":"Gaurav sent bits to a bitcoin address","Description":"","Time":"2015-11-23T09:11:31","RefNumber":"635838666931514726","Name":"Gaurav","RefGuid":"786ea1bc-94db-47b0-a0a0-c1cec43ab428","PaymentTypeId":null,"PaymentTypeGuid":null},{"AcitvityType":"\u200b90","SourceImageUrl":"https://static.zebpay.com/airtime/RG_0.png","Title":"Hardik topped up airtime","Description":"Reliance GSM India","Time":"2015-11-23T09:09:22","RefNumber":"635838665638789287","Name":"Hardik","RefGuid":"d6e31b49-9cea-4e72-8c39-6d71433f2dc0","PaymentTypeId":"8","PaymentTypeGuid":"RG"},{"AcitvityType":"\u200b90","SourceImageUrl":"https://static.zebpay.com/airtime/UN_0.png","Title":"Hardik topped up airtime","Description":"Uninor India","Time":"2015-11-23T09:08:07","RefNumber":"635838664885254797","Name":"Hardik","RefGuid":"c3002947-dc8e-4f88-94ae-ef395b1528ba","PaymentTypeId":"10","PaymentTypeGuid":"UN"},{"AcitvityType":"\u200b40","SourceImageUrl":"https://static.zebpay.com/profilepics/863de3de-0682-4034-aedf-4dcca2157d95_0.png","Title":"Gaurav sent bits to a bitcoin address","Description":"","Time":"2015-11-23T09:08:01","RefNumber":"635838664874942379","Name":"Gaurav","RefGuid":"7c6ee61d-853b-4430-bad1-f00622f9913d","PaymentTypeId":null,"PaymentTypeGuid":null},{"AcitvityType":"\u200b70","SourceImageUrl":null,"Title":"Jayant sold bits","Description":"Cha ching","Time":"2015-11-23T09:02:06","RefNumber":"635838661266486906","Name":"Jayant","RefGuid":"a86d1795-55ba-4b6f-a793-2fbe7a9089b3","PaymentTypeId":null,"PaymentTypeGuid":null},{"AcitvityType":"\u200b90","SourceImageUrl":"https://static.zebpay.com/airtime/BS_0.png","Title":"Victor topped up airtime","Description":"BSNL Topup India","Time":"2015-11-23T08:59:47","RefNumber":"635838659880722851","Name":"Victor","RefGuid":"ebc996c9-ccb3-41c1-a713-96601eb511ef","PaymentTypeId":"3","PaymentTypeGuid":"BS"},{"AcitvityType":"\u200b60","SourceImageUrl":null,"Title":"Pradeep received bits","Description":"","Time":"2015-11-23T08:56:02","RefNumber":"635838657637020895","Name":"Pradeep","RefGuid":"0e413c32-b5f2-455d-a130-af1fc0e06626","PaymentTypeId":null,"PaymentTypeGuid":null},{"AcitvityType":"\u200b70","SourceImageUrl":null,"Title":"Gaurav bought bits","Description":"Cha ching","Time":"2015-11-23T08:54:50","RefNumber":"635838656907440395","Name":"Gaurav","RefGuid":"94e45bd9-5bd0-4dda-8b3d-b8cbe39a3f04","PaymentTypeId":null,"PaymentTypeGuid":null},{"AcitvityType":"\u200b80","SourceImageUrl":"https://static.zebpay.com/images/b4a35077-f89a-4054-ac28-634410d0b5ad_0.png","Title":"Sachin bought a voucher","Description":"BookMyShow Voucher","Time":"2015-11-23T08:54:21","RefNumber":"635838656638643783","Name":"Sachin","RefGuid":"ef5c5012-6b7d-4da2-b540-d598f7218f05","PaymentTypeId":null,"PaymentTypeGuid":null},{"AcitvityType":"\u200b60","SourceImageUrl":null,"Title":"Yavan received bits","Description":"","Time":"2015-11-23T08:47:45","RefNumber":"635838652659616259","Name":"Yavan","RefGuid":"f3c6f545-fe80-47f0-a726-2cfb5704b64c","PaymentTypeId":null,"PaymentTypeGuid":null},{"AcitvityType":"\u200b70","SourceImageUrl":null,"Title":"Amit sold bits","Description":"Cha ching","Time":"2015-11-23T08:39:03","RefNumber":"635838647431632010","Name":"Amit","RefGuid":"fda705f2-b4bc-4f8d-9811-825c5201d993","PaymentTypeId":null,"PaymentTypeGuid":null},{"AcitvityType":"\u200b40","SourceImageUrl":null,"Title":"Bhupendra sent bits to a bitcoin address","Description":"","Time":"2015-11-23T08:30:51","RefNumber":"635838642518244383","Name":"Bhupendra","RefGuid":"d5793f40-8ed4-4149-bb5d-3b1da0e04e45","PaymentTypeId":null,"PaymentTypeGuid":null},{"AcitvityType":"\u200b90","SourceImageUrl":"https://static.zebpay.com/airtime/BS_0.png","Title":"Jitendra topped up airtime","Description":"BSNL Topup India","Time":"2015-11-23T08:30:39","RefNumber":"635838642405296647","Name":"Jitendra","RefGuid":"28b74925-1538-49fe-bebd-2e879748e929","PaymentTypeId":"3","PaymentTypeGuid":"BS"},{"AcitvityType":"\u200b60","SourceImageUrl":"https://static.zebpay.com/profilepics/06d6e423-0a57-4427-bbeb-041fbf01808b_0.png","Title":"Sandeep received bits","Description":"","Time":"2015-11-23T08:25:39","RefNumber":"635838639404687534","Name":"Sandeep","RefGuid":"d58a3718-6775-4c98-bba0-1e40ccc91dd2","PaymentTypeId":null,"PaymentTypeGuid":null},{"AcitvityType":"\u200b60","SourceImageUrl":null,"Title":"GAUTAM received bits","Description":"","Time":"2015-11-23T08:16:10","RefNumber":"635838633716805353","Name":"GAUTAM","RefGuid":"eb2b4944-b371-4a1e-8bba-8f021f55b218","PaymentTypeId":null,"PaymentTypeGuid":null},{"AcitvityType":"\u200b60","SourceImageUrl":null,"Title":". received bits","Description":"","Time":"2015-11-23T08:05:10","RefNumber":"635838627111699539","Name":".","RefGuid":"dd1179bc-29c1-472b-8ee6-baa5fb58b402","PaymentTypeId":null,"PaymentTypeGuid":null},{"AcitvityType":"\u200b40","SourceImageUrl":"https://static.zebpay.com/profilepics/881772c0-b707-46b7-bcbc-ded0cc48d115_0.png","Title":"Benudhar sent bits to a bitcoin address","Description":"","Time":"2015-11-23T08:02:37","RefNumber":"635838625596365362","Name":"Benudhar","RefGuid":"66335dff-28c7-4540-aecc-7769163550b0","PaymentTypeId":null,"PaymentTypeGuid":null},{"AcitvityType":"\u200b60","SourceImageUrl":null,"Title":"Pavneet received bits","Description":"","Time":"2015-11-23T07:53:00","RefNumber":"635838619860690702","Name":"Pavneet","RefGuid":"7ae946a0-e76a-43dc-b591-6678b4232ca0","PaymentTypeId":null,"PaymentTypeGuid":null},{"AcitvityType":"\u200b60","SourceImageUrl":null,"Title":"Hesham received bits","Description":"","Time":"2015-11-23T07:53:00","RefNumber":"635838619850691221","Name":"Hesham","RefGuid":"04198381-b520-461c-ae01-f0f29f39de71","PaymentTypeId":null,"PaymentTypeGuid":null},{"AcitvityType":"\u200b60","SourceImageUrl":null,"Title":"PANKAJ received bits","Description":"","Time":"2015-11-23T07:53:00","RefNumber":"635838619837878858","Name":"PANKAJ","RefGuid":"780b52f6-37fe-484f-9925-651ec5fd0401","PaymentTypeId":null,"PaymentTypeGuid":null},{"AcitvityType":"\u200b60","SourceImageUrl":null,"Title":"Amit received bits","Description":"","Time":"2015-11-23T07:53:00","RefNumber":"635838619834250950","Name":"Amit","RefGuid":"0432240f-3489-4415-a061-ba089ec764a3","PaymentTypeId":null,"PaymentTypeGuid":null},{"AcitvityType":"\u200b40","SourceImageUrl":null,"Title":"Pradeep sent bits to a bitcoin address","Description":"","Time":"2015-11-23T07:49:46","RefNumber":"635838617877866922","Name":"Pradeep","RefGuid":"6f3fc6e6-0a7e-44bc-8451-5aa0435dcf99","PaymentTypeId":null,"PaymentTypeGuid":null},{"AcitvityType":"\u200b40","SourceImageUrl":"https://static.zebpay.com/profilepics/881772c0-b707-46b7-bcbc-ded0cc48d115_0.png","Title":"Benudhar sent bits to a bitcoin address","Description":"","Time":"2015-11-23T07:44:57","RefNumber":"635838614989973393","Name":"Benudhar","RefGuid":"406cdb6f-7d39-4a97-a857-5bc7c688a073","PaymentTypeId":null,"PaymentTypeGuid":null},{"AcitvityType":"\u200b40","SourceImageUrl":null,"Title":"Kaushik sent bits to a bitcoin address","Description":"","Time":"2015-11-23T07:38:34","RefNumber":"635838611155389334","Name":"Kaushik","RefGuid":"2661b843-dc90-4c6c-b41c-7799a460dada","PaymentTypeId":null,"PaymentTypeGuid":null},{"AcitvityType":"\u200b90","SourceImageUrl":"https://static.zebpay.com/airtime/POTD_0.png","Title":"Kunjan topped up airtime","Description":"Tata Docomo India","Time":"2015-11-23T07:31:03","RefNumber":"635838606652725056","Name":"Kunjan","RefGuid":"a7036c72-e969-4e5b-b194-8fd1de622823","PaymentTypeId":"507","PaymentTypeGuid":"POTD"}]
     * returncode : ​1
     */

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
