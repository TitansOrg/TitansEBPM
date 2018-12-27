USE [ArisPub]
GO
/****** Object:  Table [dbo].[sys_user_role]    Script Date: 2018/12/27 9:04:49 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[sys_user_role](
    [id] [varchar](36) NOT NULL,
    [sys_user_id] [varchar](32) ,
    [sys_role_id] [varchar](32),
PRIMARY KEY CLUSTERED 
(
    [id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
