//package codingon.travelwith.config;
//
//import lombok.Value;
//import lombok.val;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//class S3Config(
//        @Value("\${aws.s3.accessKey}")
//        private val accessKey: String,
//        @Value("\${aws.s3.secretKey}")
//        private val secretKey: String,
//        ) {
//    @Bean
//    <fun>
//    fun amazonS3Client(): AmazonS3 {
//        return AmazonS3ClientBuilder.standard()
//                .withCredentials(
//                        AWSStaticCredentialsProvider(BasicAWSCredentials(accessKey, secretKey))
//                )
//                .withRegion(Regions.AP_NORTHEAST_2)
//                .build()
//    }
//}