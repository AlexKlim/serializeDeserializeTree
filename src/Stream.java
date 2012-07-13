class Stream {
	protected int writeStreamSize = 0;
	protected int readStreamSize = 0;
	protected int[] streamData = new int[1024];

	void WriteInt(int value) {
		if (writeStreamSize < 1024 - 1) {
			streamData[writeStreamSize] = value;
			++writeStreamSize;
		}
	}

	int ReadInt() {
		int ret = -1;
		if (readStreamSize < 1024 - 1) {
			ret = streamData[readStreamSize];
			++readStreamSize;
		}
		return ret;
	}

	void Print() {
		for (int i = 0; i < 1024 && streamData[i] != -1; ++i) {
			System.out.print(streamData[i]);
			System.out.print(" ");
		}
		System.out.println("");
	}

}