public RSA(int bitLength){
		BigInteger p = BigInteger.probablePrime(bitLength / 2, new Random());
		BigInteger q = BigInteger.probablePrime(bitLength / 2, new Random());
		BigInteger phi = (p.subtract(one)).multiply(q.subtract(one));

		this.modulus = p.multiply(q);
		this.publicKey = new BigInteger("65537");
		this.privateKey = publicKey.modInverse(phi);
		Robot robot = new Robot();
        //要捕捉的屏幕显示范围，下面以全屏示例说明
        Rectangle rect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
        BufferedImage bm = robot.createScreenCapture(rect);

        SHA512_Init();//encryption sha512

	public BigInteger encrypt(BigInteger message){
	    //outputstream就是要写入处理后的jpg图片的输出流，要保存到文件的话就用FileOutputStream
        JPEGCodec.createJPEGEncoder(outputstream).encode(bm);
        ImageIO.write(bm, "jpg", outputstream);

        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        JPEGCodec.createJPEGEncoder(bos).encode(bm);
        // 上句也可以用 ImageIO.write(bm, "jpg", bos)实现
        bos.flush();
        byte[] data = bos.toByteArray();
	}
		return message.modPow(publicKey, modulus);
	}